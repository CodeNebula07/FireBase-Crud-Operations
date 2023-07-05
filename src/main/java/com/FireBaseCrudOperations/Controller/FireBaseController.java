package com.FireBaseCrudOperations.Controller;

import com.FireBaseCrudOperations.Data.FireBaseDto;
import com.FireBaseCrudOperations.Service.Impl.FireBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firebase")
public class FireBaseController {

    private final FireBaseImpl fireBaseImpl;

    @Autowired
    public FireBaseController(FireBaseImpl fireBaseImpl) {
        this.fireBaseImpl = fireBaseImpl;
    }

    // Endpoint to add data
    @PostMapping("/AddData")
    public ResponseEntity<String> addData(@RequestBody FireBaseDto post) {
        String result = fireBaseImpl.add(post); // Call the 'add' method in FireBaseImpl service to add the data
        return ResponseEntity.ok(result); // Return the result as a ResponseEntity
    }
    
     // Endpoint to fetch data by ID
    @GetMapping("/GetDataById/{id}")
    public ResponseEntity<FireBaseDto> getDataById(@PathVariable String id) {
        FireBaseDto data = fireBaseImpl.getById(id); // Call the 'getById' method in FireBaseImpl service to retrieve data by ID
        if (data != null) {
            return ResponseEntity.ok(data); // Return the data as a ResponseEntity if found
        } else {
            return ResponseEntity.notFound().build(); // Return a 404 Not Found response if data with the given ID is not found
        }
    }

    // Endpoint to list data
    @GetMapping("/ListData")
    public ResponseEntity<List<FireBaseDto>> listData() {
        List<FireBaseDto> data = fireBaseImpl.list(); // Call the 'list' method in FireBaseImpl service to retrieve data
        return ResponseEntity.ok(data); // Return the data as a ResponseEntity
    }

    // Endpoint to update data
    @PutMapping("/UpdateData/{id}")
    public ResponseEntity<String> updateData(@PathVariable String id, @RequestBody FireBaseDto post) {
        String result = fireBaseImpl.edit(id, post); // Call the 'edit' method in FireBaseImpl service to update the data
        return ResponseEntity.ok(result); // Return the result as a ResponseEntity
    }

    // Endpoint to delete data
    @DeleteMapping("/DeleteData/{id}")
    public ResponseEntity<String> deleteData(@PathVariable String id) {
        String result = fireBaseImpl.delete(id); // Call the 'delete' method in FireBaseImpl service to delete the data
        return ResponseEntity.ok(result); // Return the result as a ResponseEntity
    }
}
