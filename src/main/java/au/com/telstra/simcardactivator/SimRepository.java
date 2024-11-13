package au.com.telstra.simcardactivator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SimRepository{

    private static final List<SimCard> list = new ArrayList<>();

    static {
        long fakeid1 = 1;
        long fakeid2 = 2;
        long fakeid3 = 3;
        list.add(new SimCard("1234567890", "test@gmail.com"));
        list.get(0).setId(fakeid1);
        list.add(new SimCard("8541616851", "omg@gmail.com"));
        list.get(1).setId(fakeid2);
        list.add(new SimCard("6264948623", "pokemans@gmail.com"));
        list.get(2).setId(fakeid3);
    }

    public List<SimCard> getAllSimCard(){
        return list;
    }

    public void addSimCard(SimCard simCard){
        list.add(simCard);
    }
    
    public SimCard findById(long id){
        for (SimCard simCard : list) {
            if (simCard.getId() == id) {
                return simCard;
            }
        }
             return null;
    }
} 
/*public interface SimRepository extends CrudRepository<SimCard, Long> {
    SimCard findById(long id);
}
*/

