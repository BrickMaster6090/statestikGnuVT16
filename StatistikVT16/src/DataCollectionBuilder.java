import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ntn13dcm
 * @author ofk14den
 * @version 2016-02-17
 *
 */
public class DataCollectionBuilder {

	private DataSource xData;
	private DataSource yData;
	private Resolution resolution;

	private Map<String, MatchedDataPair> finalResult;

	/**
	 * DataCollectionBuilder is the constructor of the DataCollectionBuilder
	 * class.
	 * 
	 * @param xData
	 *            DataSource
	 * @param yData
	 *            DataSource
	 * @param resolution
	 *            Resolution
	 */
	public DataCollectionBuilder(DataSource xData, DataSource yData, Resolution resolution) {
		this.xData = xData;
		this.yData = yData;
		this.resolution = resolution;

	}

	/**
	 * getTitle returns the names of the datasource 1 and 2 in a combined
	 * sentence.
	 * 
	 * @return String
	 */
	public String getTitle() {

		return xData.getName() + "/" + yData.getName();

	}

	/**
	 * creates a DataCollection and returns it.
	 * 
	 * @return DataCollection
	 */
	public DataCollection getResult() {
		compileData();
		DataCollection collection = new DataCollection(getTitle(), xData.getUnit(), yData.getUnit(), finalResult);

		return collection;
	}

	private Map<String, MatchedDataPair> compileData() {
		MatchedDataPair matchdatapair;

		finalResult = new HashMap<String, MatchedDataPair>();
		String keyname = "";
		String xPreviusKey = "";
		int divvaluex = 1, divvaluey = 0;
		Double xequalvalue = 0.0, yequalvalue = 0.0;

		for (LocalDate xCurrentKey : xData.getData().keySet()) {

			if (resolution.createLabel(xCurrentKey).equals(xPreviusKey) == false) {

				xPreviusKey = resolution.createLabel(xCurrentKey);

				if (yequalvalue != 0.0) {
					xequalvalue = xequalvalue / divvaluex;
					yequalvalue = yequalvalue / divvaluey;

					matchdatapair = new MatchedDataPair(xequalvalue, yequalvalue);

					finalResult.put(keyname, matchdatapair);

					xequalvalue = 0.0;
					yequalvalue = 0.0;
					divvaluex = 1;
					divvaluey = 0;
				}
				for (LocalDate comaprekey : yData.getData().keySet()) {

					if (resolution.createLabel(xCurrentKey).equals(resolution.createLabel(comaprekey))) {

						divvaluey++;
						yequalvalue = yequalvalue + yData.getData().get(comaprekey);

					}

				}
				if (yequalvalue != 0.0)
					xequalvalue = xData.getData().get(xCurrentKey);

				keyname = resolution.createLabel(xCurrentKey);

			} else {
				xequalvalue = xequalvalue + xData.getData().get(xCurrentKey);

				divvaluex++;

			}

		}

		if (yequalvalue != 0.0) {
			xequalvalue = xequalvalue / divvaluex;
			yequalvalue = yequalvalue / divvaluey;

			matchdatapair = new MatchedDataPair(xequalvalue, yequalvalue);

			finalResult.put(keyname, matchdatapair);

			xequalvalue = 0.0;
			yequalvalue = 0.0;
			divvaluex = 1;
			divvaluey = 0;
		}

		return finalResult;

	}

}
