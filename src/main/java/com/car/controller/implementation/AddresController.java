
package com.car.controller.implementation;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.car.controller.AbstractController;
import com.car.domain.Addres;
import com.car.dto.AddresDto;
import com.car.mapper.AbstractMapper;
import com.car.mapper.AddresMapper;
import com.car.service.AbstractService;
import com.car.service.AddresService;

@RequestMapping(value = "/addres")
@RestController
@AllArgsConstructor
public class AddresController extends AbstractController<Addres, AddresDto, Integer> {
    private final AddresService addresService;
    private final AddresMapper addresMapper;

    @Override
    protected AbstractService<Addres, Integer> getService() {
        return addresService;
    }

    @Override
    protected AbstractMapper<Addres, AddresDto> getMapper() {
        return addresMapper;
    }
}
