import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Policy {
	String id;
	int priority;
	Factor f;
	
	public Policy(Element pol) {
		// TODO Auto-generated constructor stub
		id = pol.getAttribute("id");
		priority = Integer.parseInt(pol.getAttribute("priority"));

		NodeList nl = pol.getElementsByTagName("factor");
		f = new Factor((Element)nl.item(0));
		
		System.out.println(f.getVehicle_number());
	}

	
	class Factor {
		String location_target;
		String location_edges;
		String vehicle_target;
		int vehicle_number;
		
		public Factor(Element elem) {
			
			//location 노드 파싱
			NodeList list = elem.getElementsByTagName("location");
			String target = ((Element)list.item(0)).getAttribute("target");
			//location type 이 edges일 경우의 처리
			if (target.compareTo("edges")==0){
				location_target = target;
				location_edges = ((Element)list.item(0)).getTextContent();
			}//all일 경우의 처리
			else if (target.compareTo("all")==0){
				location_target = target;
				location_edges = "";
			}
			
			//vehicle 노드 파싱
			list = elem.getElementsByTagName("vehicle");
			vehicle_target = ((Element)list.item(0)).getAttribute("target");
			vehicle_number = Integer.parseInt(((Element)list.item(0)).getElementsByTagName("number").item(0).getTextContent());			
		}
		
		public String getLocation_target(){
			return location_target;
		}
		public String getLocation_edges(){
			return location_edges;
		}
		public String getVehicle_target(){
			return vehicle_target;
		}
		public int getVehicle_number(){
			return vehicle_number;
		}
	}
	
	
	
}
