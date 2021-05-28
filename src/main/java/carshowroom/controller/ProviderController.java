package carshowroom.controller;

import carshowroom.model.Provider;
import carshowroom.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {

    @Qualifier("providerServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/provider/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Provider> getProviderById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Provider provider = (Provider) this.generalService.findById(id);

        if (provider == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(provider, HttpStatus.OK);
    }

    @RequestMapping(value = "/provider", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Provider> addProvider(@RequestBody Provider provider) {
        HttpHeaders headers = new HttpHeaders();
        if (provider == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.generalService.save(provider);
        return new ResponseEntity<>(provider, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/provider/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Provider> updateProvider(@PathVariable("id") Long id, @RequestBody Provider newProvider) {
        HttpHeaders headers = new HttpHeaders();
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Provider provider = (Provider) this.generalService.findById(id);

        if (provider == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.update(newProvider, id);
        return new ResponseEntity<>(newProvider, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/provider/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Provider> deleteProvider(@PathVariable("id") Long id) {
        Provider provider = (Provider) this.generalService.findById(id);

        if (provider == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/providers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providers = this.generalService.findAll();

        if (providers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(providers, HttpStatus.OK);
    }
}