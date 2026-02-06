package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nt.VO.ConsultationVO;
import com.nt.service.ConsultationService;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationRestController {

    @Autowired
    private ConsultationService consultationService;

    // ---------------- CREATE ----------------
    @PostMapping
    public ResponseEntity<ConsultationVO> createConsultation(
            @RequestBody ConsultationVO vo) {

        ConsultationVO saved = consultationService.createConsultation(vo);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ---------------- UPDATE (FULL) ----------------
    @PutMapping("/{id}")
    public ResponseEntity<ConsultationVO> updateConsultation(
            @PathVariable Long id,
            @RequestBody ConsultationVO vo) {

        ConsultationVO updated = consultationService.updateConsultation(id, vo);
        return ResponseEntity.ok(updated);
    }

    // ---------------- PARTIAL UPDATE ----------------
    @PatchMapping("/updateById/{id}")
    public ResponseEntity<ConsultationVO> partialUpdateConsultation(
            @PathVariable Long id,
            @RequestBody Map<String, Object> fields) {

        ConsultationVO updated =
                consultationService.partialUpdateConsultation(id, fields);
        return ResponseEntity.ok(updated);
    }

    // ---------------- GET BY ID ----------------
    @GetMapping("/showById/{id}")
    public ResponseEntity<ConsultationVO> getConsultationById(
            @PathVariable Long id) {

        ConsultationVO vo = consultationService.getConsultationById(id);
        return ResponseEntity.ok(vo);
    }

    // ---------------- GET ALL ----------------
    @GetMapping("/showAll")
    public ResponseEntity<List<ConsultationVO>> getAllConsultations() {

        List<ConsultationVO> list = consultationService.getAllConsultations();
        return ResponseEntity.ok(list);
    }

    // ---------------- DELETE BY ID ----------------
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteConsultationById(
            @PathVariable Long id) {

        consultationService.deleteConsultationById(id);
        return ResponseEntity.ok("Consultation deleted successfully");
    }

    // ---------------- DELETE ALL ----------------
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllConsultations() {

        consultationService.deleteAllConsultations();
        return ResponseEntity.ok("All consultations deleted successfully");
    }
}
