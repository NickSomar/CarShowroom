package carshowroom.controller;

import carshowroom.model.Rent;
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
public class RentController {

    @Qualifier("rentServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rent> getRentById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Rent rent = (Rent) this.generalService.findById(id);

        if (rent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    @RequestMapping(value = "/rent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
        HttpHeaders headers = new HttpHeaders();
        if (rent == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.generalService.save(rent);
        return new ResponseEntity<>(rent, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rent> updateRent(@PathVariable("id") Long id, @RequestBody Rent newRent) {
        HttpHeaders headers = new HttpHeaders();
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Rent rent = (Rent) this.generalService.findById(id);

        if (rent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.update(newRent, id);
        return new ResponseEntity<>(newRent, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rent> deleteRent(@PathVariable("id") Long id) {
        Rent rent = (Rent) this.generalService.findById(id);

        if (rent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/rents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rent>> getAllRents() {
        List<Rent> rents = this.generalService.findAll();

        if (rents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rents, HttpStatus.OK);
    }
}