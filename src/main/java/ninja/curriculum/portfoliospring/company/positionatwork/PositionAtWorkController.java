package ninja.curriculum.portfoliospring.company.positionatwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/position-at-work")
public class PositionAtWorkController {
    private final PositionAtWorkService positionAtWorkService;

    @Autowired
    public PositionAtWorkController(PositionAtWorkService positionAtWorkService) {
        this.positionAtWorkService = positionAtWorkService;
    }

    @GetMapping(path = "/all")
    public List<PositionAtWork> getPositionAtWorks() {
        return this.positionAtWorkService.getCompanies();
    }

    @PostMapping
    public void addPositionAtWork(@RequestBody PositionAtWork positionAtWork) {
        this.positionAtWorkService.addPositionAtWork(positionAtWork);
    }

    @GetMapping(path = "/{positionAtWorkId}")
    public PositionAtWork getPositionAtWork(@PathVariable Long positionAtWorkId) {
        return this.positionAtWorkService.getPositionAtWork(positionAtWorkId);
    }

    @PutMapping(path = "/update/{positionAtWorkId}")
    public void updatePositionAtWork(@PathVariable Long positionAtWorkId, @RequestParam(required = false) String nameItaly) {
        this.positionAtWorkService.updatePositionAtWork(positionAtWorkId, nameItaly);
    }

}
