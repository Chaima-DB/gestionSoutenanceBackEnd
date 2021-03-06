package com.zsmart.gestionDesSoutenances.ws.rest;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;

@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/doctorant")
public class DoctorantRest {

    @Autowired
    DoctorantService doctorantService;
    
    @GetMapping("/email/{email}")
    public Doctorant findByUserEmail(@PathVariable String email) {
		return doctorantService.findByUserEmail(email);
	}

	@GetMapping("/")
   // @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public List<Doctorant> findAll() {
        return doctorantService.findAll();
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return doctorantService.deleteByCin(cin);
    }

    @GetMapping("/cin/{cin}")
    public Doctorant findByCin(@PathVariable String cin) {
        return doctorantService.findByCin(cin);
    }

    @GetMapping("/cne/{cne}")
    public Doctorant findByCne(@PathVariable String cne) {
        return doctorantService.findByCne(cne);
    }

    @PostMapping("/")
    public int save(@RequestBody Doctorant doctorant) {
        return doctorantService.save(doctorant);
    }

    @PutMapping("/id/{id}")
    public int update(@RequestBody Doctorant doctorant, @PathVariable Long id) {
        return doctorantService.update(doctorant, id);
    }

    @PutMapping("/update/id/{id}")
    public int updateDoctorat(@RequestBody Doctorant doctorant, @PathVariable Long id) {
        return doctorantService.updateDoctorat(doctorant, id);
    }
    @PostMapping("/add/")
    public int updateAddRapporteurs(@RequestBody Doctorant doctorant) {
        return doctorantService.updateAddRapporteurs(doctorant, doctorant.getRapporteurs());
    }
    @GetMapping("/nv/{nv}")
    public List<Doctorant> findByNv(@PathVariable int nv) {
        return doctorantService.findByNv(nv);
    }
    @PutMapping("/updateAfterConfirmation/cin/{cin}")
    public int afterConfirmation(@PathVariable String cin) {
        return doctorantService.afterConfirmation(cin);
    }
    @PutMapping("/updateBeforConfirmation/id/{id}")
    public int beforConfirmation(@RequestBody Doctorant doctorant, @PathVariable Long id) {
        return doctorantService.beforConfirmation(doctorant, id);
    }
    

}
