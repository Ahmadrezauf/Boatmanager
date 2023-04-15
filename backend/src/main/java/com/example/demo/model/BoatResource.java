@RestController
@RequestMapping("/api/users/{userId}/boats/{boatId}/resources")
public class BoatResource {

    @Autowired
    private BoatService boatService;

    @GetMapping
    public List<Resource> getAllResources(@PathVariable Long userId, @PathVariable Long boatId) {
        return boatService.getAllResources(userId, boatId);
    }

    @PostMapping
    public Resource addResource(@PathVariable Long userId, @PathVariable Long boatId, @RequestBody Resource resource) {
        return boatService.addResource(userId, boatId, resource);
    }

    @PutMapping("/{resourceId}")
    public Resource updateResource(@PathVariable Long userId, @PathVariable Long boatId, @PathVariable Long resourceId, @RequestBody Resource resource) {
        return boatService.updateResource(userId, boatId, resourceId, resource);
    }

    @DeleteMapping("/{resourceId}")
    public void deleteResource(@PathVariable Long userId, @PathVariable Long boatId, @PathVariable Long resourceId) {
        boatService.deleteResource(userId, boatId, resourceId);
    }
}
