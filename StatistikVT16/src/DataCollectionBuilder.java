import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataCollectionBuilder {

	private DataSource xData;
	private DataSource yData;
	private Resolution resolution;
	
	private Map<String, MatchedDataPair> finalResult;

	private List<MatchedDataPair> matchList = new ArrayList<MatchedDataPair>();

	public DataCollectionBuilder(DataSource xData, DataSource yData, Resolution resolution) {
		this.xData = xData;
		this.yData = yData;
		this.resolution = resolution;

	}

	public String getTitle() {

		return xData.getName() + "/" + yData.getName();

	}

	public DataCollection getResult() {
		CalculateData();
		DataCollection collection = new DataCollection(getTitle(), xData.getUnit(), yData.getUnit(), finalResult);

		return collection;
	}

	private Map<String, MatchedDataPair> CalculateData() {
		MatchedDataPair matchdatapairyear;

		finalResult = new HashMap<String, MatchedDataPair>();
		String keyname = "hej";
		String xoldyear = "";
		int divvaluex = 1, divvaluey = 0;
		Double xsum = 0.0, ysum = 0.0;

		for (LocalDate Key : xData.getData().keySet()) {

			if (resolution.trim(Key).equals(xoldyear) == false) {

				xoldyear = resolution.trim(Key);

				if (ysum != 0.0) {
					xsum = xsum / divvaluex;
					ysum = ysum / divvaluey;

					matchdatapairyear = new MatchedDataPair(xsum, ysum);

					AddToList(matchdatapairyear);
					finalResult.put(keyname, matchdatapairyear);

					xsum = 0.0;
					ysum = 0.0;
					divvaluex = 1;
					divvaluey = 0;
				}
				for (LocalDate comaprekey : yData.getData().keySet()) {

					if (resolution.trim(Key).equals(resolution.trim(comaprekey))) {

						divvaluey++;
						ysum = ysum + yData.getData().get(comaprekey);

					}

				}
				if (ysum != 0.0)
					xsum = xData.getData().get(Key);

				keyname = resolution.trim(Key);

			} else {
				xsum = xsum + xData.getData().get(Key);

				divvaluex++;

			}

		}

		if (ysum != 0.0) {
			xsum = xsum / divvaluex;
			ysum = ysum / divvaluey;

			matchdatapairyear = new MatchedDataPair(xsum, ysum);

			AddToList(matchdatapairyear);
			finalResult.put(keyname, matchdatapairyear);

			xsum = 0.0;
			ysum = 0.0;
			divvaluex = 1;
			divvaluey = 0;
		}

		return finalResult;

	}

	private void AddToList(MatchedDataPair matchdatapair) {

		matchList.add(matchdatapair);

	}

	public List<MatchedDataPair> GetList() {

		return matchList;

	}

}
