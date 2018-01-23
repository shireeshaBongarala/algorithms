//import java.util.Collections;
//import java.util.List;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class test {
//    public static void main(String[] args) {
//        Sortable sortable = null;
//        System.out.println("a".equals(sortable.getOption()));
//        String json = "{\"someTypes\": [\"value\": 5]}";
//        Sortable object = new ObjectMapper().readValue(json, Sortable.class);
//    }
//
//
//    public class Sortable {
//        String option;
//        List<SomeType> someTypes = Collections.emptyList();
//
//        public String getOption() {
//            return option;
//        }
//
//        public void setOption(String option) {
//            this.option = option;
//        }
//    }
//
//    public class SomeType {
//        int value;
//    }
//}
