package carshowroom.controller;

import carshowroom.model.Tariff;
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
public class TariffController {

    @Qualifier("tariffServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/tariff/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tariff> getTariffById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Tariff tariff = (Tariff) this.generalService.findById(id);

        if (tariff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tariff, HttpStatus.OK);
    }

    @RequestMapping(value = "/tariff", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tariff> addTariff(@RequestBody Tariff tariff) {
        HttpHeaders headers = new HttpHeaders();
        if (tariff == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.generalService.save(tariff);
        return new ResponseEntity<>(tariff, headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/tariff/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tariff> updateTariff(@PathVariable("id") Long id, @RequestBody Tariff newTariff) {
        HttpHeaders headers = new HttpHeaders();
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Tariff tariff = (Tariff) this.generalService.findById(id);

        if (tariff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.update(newTariff, id);
        return new ResponseEntity<>(newTariff, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tariff/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tariff> deleteTariff(@PathVariable("id") Long id) {
        Tariff tariff = (Tariff) this.generalService.findById(id);

        if (tariff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/tariffs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tariff>> getAllTariffs() {
        List<Tariff> tariffs = this.generalService.findAll();

        if (tariffs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tariffs, HttpStatus.OK);
    }
}