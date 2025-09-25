package com.example.learningapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseRepository repo;
    public CourseController(CourseRepository repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Course> list() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Course> get(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course c) {
        var saved = repo.save(c);
        return ResponseEntity.created(URI.create("/api/courses/" + saved.getCourseID())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Integer id, @RequestBody Course c) {
        return repo.findById(id).map(existing -> {
            existing.setCourseName(c.getCourseName());
            existing.setRating(c.getRating());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
