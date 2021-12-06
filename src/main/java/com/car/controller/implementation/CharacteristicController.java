
papackage com.car.controller.implementation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.car.controller.AbstractController;
import com.car.domain.drug.Country;
import com.car.dto.drug.CountryDto;
import com.car.mapper.AbstractMapper;
import com.car.mapper.drug.CountryMapper;
import com.car.service.AbstractService;
import com.car.service.drug.CountryService;

@RequestMapping(value = "/characteristic")
@RestController
@AllArgsConstructor
public class CharacteristicController extends AbstractController<CharacteristicController, CharacteristicDto, Integer> {
    private final CharacteristicService characteristicService;
    private final CharacteristicMapper characteristicMapper;

    @Override
    protected AbstractService<Characteristic, Integer> getService() {
        return characteristicService;
    }

    @Override
    protected AbstractMapper<Characteristic, CharacteristicDto> getMapper() {
        return characteristicMapper;
    }
}
