package co.aiml;
import java.util.Scanner;
import bitoflife.chatterbean.AliceBot;

public class Chat{
	private static AliceBotMother xmother = new AliceBotMother();
	private static AliceBot xbot;

	public static void main(String[] args) {
		try {
			xbot = xmother.newInstance();
			xbot.respond("welcome");
			xmother.setUp();
			while(true){
				String RobotSay;
				Scanner in = new Scanner(System.in);
				String personSay = in.next();;
				RobotSay=xbot.respond(personSay);
				System.out.println(RobotSay);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
