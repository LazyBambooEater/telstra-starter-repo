package au.com.telstra.simcardactivator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimController {
    @Autowired
    private SimService simService;
    
    @Autowired
    private final SimRepository repository;

    SimController(SimRepository repository) {
        this.repository = repository;
    }




    @GetMapping("/sim_activation1")
    public List<SimCard> all(){
        return repository.getAllSimCard();
    }

    @PostMapping("/sim_activation")
    public void simCardActivation(@RequestBody SimCard request){
        //Sim Number is the Iccid number for a sim card
        ActivationResponse activationResponse = simService.sendPostRequest(request.getIccid());
        if (activationResponse  != null && activationResponse.isActivated()) {
            // This is a psuedo auto incremental that would happen in a database
            long size = repository.getAllSimCard().size() + 1;
            request.setId(size);
            //Sim card is activated
            request.setActive(true);
            repository.addSimCard(request);
        }
        else {
            //Sim card failed to activate, record activation failure
            long size = repository.getAllSimCard().size() + 1;
            request.setId(size);
            repository.addSimCard(request);
        }
    }

    @GetMapping("/findSim/{id}")
    public SimCard findSim(@PathVariable Long id){
        return repository.findById(id);
    }
}
