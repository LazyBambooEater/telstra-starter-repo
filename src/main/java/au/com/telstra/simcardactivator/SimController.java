package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimController {
    @Autowired
    private SimService simService;
    

    @PostMapping("/sim_activation")
    public void SimCardActivation(@RequestBody SimCard request){
        //Sim Number is the Iccid number for a sim card
        simService.sendPostRequest(request.getSimNumber());
    }
}
