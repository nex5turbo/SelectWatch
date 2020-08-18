import java.util.*;
public class Main {

	public static void main(String[] args) {
		View view = new View();
		AlarmList alarmlist = new AlarmList(view);
		Buzzer buzzer = new Buzzer(view, alarmlist);
		Alarm alarm = new Alarm(view, alarmlist, buzzer);
		RandomDirectionGenerator rdg = new RandomDirectionGenerator(view);
		RandomNumberGenerator rng = new RandomNumberGenerator(view);
		Stopwatch stopwatch = new Stopwatch(view);
		TimeKeeping timekeeping = new TimeKeeping(view, buzzer);
		Timer timer = new Timer(view, buzzer);
		FunctionList functionlist = new FunctionList(view, alarm, rdg, rng, stopwatch, timer, timekeeping);
		SelectFunction selectfunction = new SelectFunction(view, functionlist);
		StopWatchUI swUI = new StopWatchUI(view, stopwatch);
		RandomNumberGeneratorUI rngui = new RandomNumberGeneratorUI(view, rng);
		TimeKeepingUI tkui = new TimeKeepingUI(timekeeping, view);
		TimerUI timerui = new TimerUI(timer, view);
		RandomDirectionGeneratorUI rdgui = new RandomDirectionGeneratorUI(rdg, view);
		SelectFunctionUI selectfunctionui = new SelectFunctionUI(selectfunction, view);
		AlarmUI alarmui = new AlarmUI(alarm, view);
	}
}
