package poc.workflow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Job1 implements Job {

	private static Logger _log = LoggerFactory.getLogger(Job1.class);

	public Job1() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();
		_log.info("Job1 says: " + jobKey + " executing at " + new Date());

		try {
			System.out.println("start");
			Process pr = Runtime.getRuntime().exec("python src/main/java/pyScript.py");

			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
