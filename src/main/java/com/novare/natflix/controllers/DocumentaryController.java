package com.novare.natflix.controllers;

import com.novare.natflix.dtos.DocumentaryDto;
import com.novare.natflix.services.DocumentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentaries")
public class DocumentaryController {

    @Autowired
    DocumentaryService  documentaryService;

    @GetMapping("/{id}")
    ResponseEntity<DocumentaryDto> getDocumentary(@PathVariable Long id){
        return ResponseEntity.ok().body(documentaryService.getSingleDocumentaryByMediaId(id));
    }

    ResponseEntity<Long> addDocumentary(@ModelAttribute DocumentaryDto documentaryDto){
        return ResponseEntity.ok().body(documentaryService.addDocumentary(documentaryDto));
    }

    ResponseEntity<Long> updateDocumentary(@ModelAttribute DocumentaryDto documentaryDto, @PathVariable Long id){
        documentaryDto.setId(id);
        return ResponseEntity.ok().body(documentaryService.updateDocumentary(documentaryDto));
    }

    ResponseEntity<String> deleteDocumentary(@PathVariable Long id){
        documentaryService.deleteDocumentary(id);
        return ResponseEntity.ok().body("deleted");
    }

    ResponseEntity<List<DocumentaryDto>> getAllDocumentaries(){
        return ResponseEntity.ok().body(documentaryService.getDocumentaries());
    }


}
