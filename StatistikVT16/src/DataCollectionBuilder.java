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
		MatchedDataPair matchDataPair;

		finalResult = new HashMap<String, MatchedDataPair>();
		String keyName = "";
		String xPreviusKey = "";
		int xDivValue = 1, yDivValue = 0;
		Double xEqualValue = 0.0, yEqualValue = 0.0;

		for (LocalDate xCurrentKey : xData.getData().keySet()) {

			if (resolution.createLabel(xCurrentKey).equals(xPreviusKey) == false) {

				xPreviusKey = resolution.createLabel(xCurrentKey);

				if (yEqualValue != 0.0) {
					xEqualValue = xEqualValue / xDivValue;
					yEqualValue = yEqualValue / yDivValue;

					matchDataPair = new MatchedDataPair(xEqualValue, yEqualValue);

					finalResult.put(keyName, matchDataPair);

					xEqualValue = 0.0;
					yEqualValue = 0.0;
					xDivValue = 1;
					yDivValue = 0;
				}
				for (LocalDate comapreKey : yData.getData().keySet()) {

					if (resolution.createLabel(xCurrentKey).equals(resolution.createLabel(comapreKey))) {

						yDivValue++;
						yEqualValue = yEqualValue + yData.getData().get(comapreKey);

					}

				}
				if (yEqualValue != 0.0)
					xEqualValue = xData.getData().get(xCurrentKey);

				keyName = resolution.createLabel(xCurrentKey);

			} else {
				xEqualValue = xEqualValue + xData.getData().get(xCurrentKey);

				xDivValue++;

			}

		}

		if (yEqualValue != 0.0) {
			xEqualValue = xEqualValue / xDivValue;
			yEqualValue = yEqualValue / yDivValue;

			matchDataPair = new MatchedDataPair(xEqualValue, yEqualValue);

			finalResult.put(keyName, matchDataPair);

			xEqualValue = 0.0;
			yEqualValue = 0.0;
			xDivValue = 1;
			yDivValue = 0;
		}

		return finalResult;

	}

}
