package za.ac.cput.controller.weddingsSA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.WeddingsSA;
import za.ac.cput.factory.WeddingsSAFactory;
import za.ac.cput.services.weddingsSA.WeddingsSAService;

@RestController
@RequestMapping

public class WeddingsSAController {

    @Autowired
    private WeddingsSAService weddingsSAService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public WeddingsSA create(WeddingsSA weddingsSA) {
        WeddingsSA anotherWeddings = WeddingsSAFactory.createWeddingsSA(weddingsSA.getCompanyName(), weddingsSA.getContact());
        return weddingsSAService.create(anotherWeddings);
    }
        @GetMapping("/read")
        public WeddingsSA read (@RequestBody WeddingsSA weddingsSA){ return weddingsSAService.read(weddingsSA.getCompanyName()); }

        @PostMapping("/update")
            public WeddingsSA update(@RequestBody WeddingsSA weddingsSA){
                return weddingsSAService.update(weddingsSA);
            }

            @PostMapping
                public String delete(@RequestBody WeddingsSA weddingsSA){
             if(weddingsSAService.delete(weddingsSA.getCompanyName()))
                        return "weddingsSA deleted successfully";

     else
            return "WeddingsSA could not be deleted";

    }
}
