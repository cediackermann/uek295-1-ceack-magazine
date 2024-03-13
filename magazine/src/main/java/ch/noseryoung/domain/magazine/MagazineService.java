package ch.noseryoung.domain.magazine;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MagazineService {

  @Autowired private MagazineRepository magazineRepository;

  public Magazine createMagazine(Magazine magazine) {
    return magazineRepository.save(magazine);
  }

  public Magazine getMagazineById(int magazineId) {
    return magazineRepository.findById(magazineId).orElseThrow();
  }

  public Magazine updateMagazine(Magazine magazine, int magazineId) {
    magazine.setMagazineId(magazineId);
    return magazineRepository.save(magazine);
  }

  public Magazine deleteMagazine(int magazineId) {
    Magazine magazine =
        magazineRepository.findById(magazineId).orElseThrow(() -> new NoSuchElementException());
    magazineRepository.deleteById(magazineId);
    return magazine;
  }

  public Iterable<Magazine> getAllMagazines() {
    return magazineRepository.findAll();
  }
}
