@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAllBoats() {
        return boatRepository.findAll();
    }

    public Optional<Boat> getBoatById(Long id) {
        return boatRepository.findById(id);
    }

    public Boat saveBoat(Boat boat) {
        return boatRepository.save(boat);
    }

    public void deleteBoatById(Long id) {
        boatRepository.deleteById(id);
    }
}
