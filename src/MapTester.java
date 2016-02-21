import java.util.HashMap;
import java.util.Map;

public class MapTester {

	public static void main(String[] args) {
		Map<Integer, String> doors = new HashMap<>();
		
		doors.put(1, "door_1");
		doors.put(2, "door_2");
		doors.put(3, "door_3");
		
		
		Map<Integer, String> goats = new HashMap<>(doors);
		goats.remove(2);
		
		System.out.println(goats);
		
		
	}


}
