package com.example.threefatftw;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// maybe this isnt the best name, but its better then Main ;-)
class Currency {

	static Logger log = LoggerFactory.getLogger(Currency.class);

    public static double[] convert(int initial, int result) {

		String[] unitArray = {"USDBIF", "USDMWK", "USDBYR", "USDBYN", "USDHUF", "USDAOA", "USDJPY", "USDMNT", "USDPLN", "USDGBP", "USDSBD", "USDAWG", "USDKRW", "USDNPR", "USDINR", "USDYER", "USDAFN", "USDMVR", "USDKZT", "USDSRD", "USDSZL", "USDLTL", "USDSAR", "USDTTD", "USDBHD", "USDHTG", "USDANG", "USDPKR", "USDXCD", "USDLKR", "USDNGN", "USDCRC", "USDCZK", "USDZWL", "USDGIP", "USDRON", "USDMMK", "USDMUR", "USDNOK", "USDSYP", "USDIMP", "USDCAD", "USDBGN", "USDRSD", "USDDOP", "USDKMF", "USDCUP", "USDGMD", "USDTWD", "USDIQD", "USDSDG", "USDBSD", "USDSLL", "USDCUC", "USDZAR", "USDTND", "USDCLP", "USDHNL", "USDUGX", "USDMXN", "USDSTD", "USDLVL", "USDSCR", "USDCDF", "USDBBD", "USDGTQ", "USDFJD", "USDTMT", "USDCLF", "USDBRL", "USDPEN", "USDNZD", "USDWST", "USDNIO", "USDBAM", "USDEGP", "USDMOP", "USDNAD", "USDBZD", "USDMGA", "USDXDR", "USDCOP", "USDRUB", "USDPYG", "USDISK", "USDJMD", "USDLYD", "USDBMD", "USDKWD", "USDPHP", "USDBDT", "USDCNY", "USDTHB", "USDUZS", "USDXPF", "USDMRO", "USDIRR", "USDARS", "USDQAR", "USDGNF", "USDERN", "USDMZN", "USDSVC", "USDBTN", "USDUAH", "USDKES", "USDSEK", "USDCVE", "USDAZN", "USDTOP", "USDOMR", "USDPGK", "USDXOF", "USDGEL", "USDBTC", "USDUYU", "USDMAD", "USDFKP", "USDMYR", "USDEUR", "USDLSL", "USDDKK", "USDJOD", "USDHKD", "USDRWF", "USDAED", "USDBWP", "USDSHP", "USDTRY", "USDLBP", "USDTJS", "USDIDR", "USDKYD", "USDAMD", "USDGHS", "USDGYD", "USDKPW", "USDBOB", "USDKHR", "USDMDL", "USDAUD", "USDILS", "USDTZS", "USDVND", "USDXAU", "USDZMW", "USDLRD", "USDXAG", "USDALL", "USDCHF", "USDHRK", "USDDJF", "USDXAF", "USDKGS", "USDSOS", "USDVEF", "USDVUV", "USDLAK", "USDBND", "USDZMK", "USDETB", "USDJEP", "USDDZD", "USDPAB", "USDGGP", "USDSGD", "USDMKD", "USDUSD"};

		ObjectMapper mapper = new ObjectMapper();
		double[] rates = new double[2];
		// right now every single time you call "convert()" you open, read, and parse the json file.
			// consider making an instance of Currency and parsing the file 1 time and keeping it in memory
			// … if you suspect that lots of calls to the method "convert()" will happen
			try {
				var content = Files.readString(Paths.get("src/main/resources/lastUpdatedValues.json"));
				var jobj = mapper.readTree(content);
				var quotes = jobj.get("quotes");
				rates[0] = quotes.get(unitArray[initial]).asDouble();
				rates[1] = quotes.get(unitArray[result]).asDouble();

//			log.info("{}/////\n\n{}: {}\n{}: {}", quotes.get(unitArray[result]), unitArray[initial], rates[0], unitArray[result], rates[1]);

			} catch (IOException ex) {
				ex.printStackTrace();
			}
//			log.info("{}: {}\n{}: {}", unitArray[initial], rates[0], unitArray[result], rates[1]);

		return rates;
	}
	record Quotes(String ref, double val) { }
}
