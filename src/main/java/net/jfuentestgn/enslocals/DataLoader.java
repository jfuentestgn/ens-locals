package net.jfuentestgn.enslocals;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.reactivex.Flowable;
import net.jfuentestgn.enslocals.domain.EnsLocalEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Singleton
@Requires(notEnv = Environment.TEST) // Don't load data in tests.
public class DataLoader implements ApplicationEventListener<ServiceStartedEvent> {

	private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

	private final EnsLocalRepository ensLocalRepository;

	public DataLoader(final EnsLocalRepository ensLocalRepository) {
		this.ensLocalRepository = ensLocalRepository;
	}

	@Override
	public void onApplicationEvent(final ServiceStartedEvent event) {
		log.info("Loading data at startup. File encoding = " + System.getProperty("file.encoding"));

		//this.loadDataFromFile("D:\\Projects\\19-05_EnsLocals\\tots_ens_xls.csv");
		this.loadDataFromFile("/tots_ens_xls.csv");
	}


	private void loadDataFromFile(String path) {
		final CSVParser parser =
				new CSVParserBuilder()
						.withSeparator(';')
						.withIgnoreQuotations(false)
						.build();

		BufferedReader br = null;
		try {
			//FileInputStream fis = new FileInputStream(path);
			InputStream fis = this.getClass().getResourceAsStream(path);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);

			String [] headerLine = this.parseNextLine(br, parser);
			int numFields = headerLine.length;

			String nextLine = null;
			String currentLine = br.readLine();

			while (currentLine != null) {
				nextLine = br.readLine();
				while (nextLine != null && !lineStartsWithCode(nextLine)) {
					currentLine = currentLine + nextLine;
					nextLine = br.readLine();
				}
				String [] parsedLine = parser.parseLineMulti(currentLine);
				if (numFields != parsedLine.length) {
					throw new IOException("Incorrect number of fields in line: " + currentLine);
				} else {
					Map<String, String> record = buildRecord(parsedLine, headerLine);
					log.info(record.toString());
					this.saveRecord(record);
				}
				currentLine = nextLine;
			}



//			String[] currentLine = this.parseNextLine(br, parser);
//			while (currentLine != null) {
//				if (numFields != currentLine.length) {
//					throw new IOException("Incorrect number of fields in line: " + currentLine);
//				}
//				Map<String,String> record = buildRecord(currentLine, headerLine);
//				log.info(record.toString());
//				this.saveRecord(record);
//				currentLine = this.parseNextLine(br, parser);
//			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private boolean lineStartsWithCode(String nextLine) {
		Pattern p = Pattern.compile("^[0-9]{9,10};");
		boolean bool = p.matcher(nextLine).lookingAt();
		if (bool) {
//			log.info("Line starts with code: " + nextLine);
		} else {
			log.info("Line DOES NOT start with code: " + nextLine);
		}
		return bool;
	}

	private void saveRecord(Map<String, String> record) throws ParseException {
		EnsLocalEntity entity = new EnsLocalEntity();
		for (Map.Entry<String,String> entry : record.entrySet()) {
			entity.setField(entry.getKey(), entry.getValue().trim());
		}
		ensLocalRepository.save(entity);
	}

	private Map<String, String> buildRecord(String[] currentLine, String[] headerLine) {
		Map<String, String> record = new HashMap<>();
		for (int i = 0; i < headerLine.length; i++) {
			record.put(headerLine[i], currentLine[i]);
		}
		return record;
	}

	private String[] parseNextLine(BufferedReader br, CSVParser parser) throws IOException {
		String line = br.readLine();
		if (line == null) {
			return null;
		}
		return parser.parseLineMulti(line);
	}
}