package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.project.rest.entity.Announcement;
import se331.project.rest.service.AnnouncementService;
import se331.project.rest.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class AnnouncementController {
    final AnnouncementService announcementService;

    @GetMapping("announcement")
    @CrossOrigin(origins = "http://localhost:3000 , http://18.208.106.67:8001")

    public ResponseEntity<?> getAnnouncements() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(announcementService.getAnnouncements()));
    }
    @PostMapping("announcement")
    public ResponseEntity<?> addAnnouncement(@RequestBody Announcement announcement) {
        Announcement output = announcementService.save(announcement);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output));
    }
}
