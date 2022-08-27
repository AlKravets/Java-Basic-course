import java.util.*;
import java.util.function.Consumer;



public class MailService<T> implements Consumer<AbstractSendable<T>> {
    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key){
          if(containsKey(key)){
              return super.get(key);
          } else{
              return Collections.<T>emptyList();
          }
      }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(AbstractSendable<T> sendable){
        String key = sendable.getTo();
        T value = sendable.get();

        if (mailBox.containsKey(key)){
            mailBox.get(key).add(value);
//            System.out.println(mailBox.toString());
        } else{
            mailBox.put(key, new ArrayList<T>(Arrays.asList(value)));
//            System.out.println(mailBox.toString());
        }
    }
}
