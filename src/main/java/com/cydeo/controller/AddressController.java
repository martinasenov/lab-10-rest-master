package com.cydeo.controller;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AddressService;
import com.cydeo.service.impl.TemperatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;
    private final TemperatureService temperatureService;

    public AddressController(AddressService addressService, TemperatureService temperatureService) {
        this.addressService = addressService;
        this.temperatureService = temperatureService;
    }


     /*
     Endpoint: /api/v1/address/{addressNo}
     HTTP Status Code: 200

     JSON Response Body:
     "success": true
     "message": "Address <addressNo> is successfully retrieved."
     "code":200
     "data":<address data>
    */

    @GetMapping("/{addressNo}")
    public ResponseEntity<ResponseWrapper> getAddressByNo(@PathVariable String addressNo) {
        AddressDTO addressDTO = addressService.findByAddressNo(addressNo);
        addressDTO.setCurrentTemperature(temperatureService.getTemperature(addressDTO.getCity()));

        ResponseWrapper responseWrapper = new ResponseWrapper("Address " + addressNo + " is successfully retrieved.", addressDTO);
        responseWrapper.setCode(200);
        return ResponseEntity.ok(responseWrapper);
    }


    @PutMapping("/{addressNo}")
    public ResponseEntity<ResponseWrapper> updateAddressByNo(@PathVariable String addressNo, @RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddress = addressService.update(addressNo, addressDTO);

        ResponseWrapper responseWrapper = new ResponseWrapper("Address " + addressNo + " is successfully updated.", updatedAddress);
        responseWrapper.setCode(200);

        return ResponseEntity.ok(responseWrapper);
    }

    /*
      Endpoint: /api/v1/address/{addressNo}

      JSON Response Body:
      <updated address data>
     */







}
