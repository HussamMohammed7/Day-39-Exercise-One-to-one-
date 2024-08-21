package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import com.example.exercisejparelationi.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = new Address(null, addressDTO.getArea(),
                addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("Address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteAddress(Integer addressId) {
        Address address = addressRepository.findAddressById(addressId);
        if (address == null) {
            throw new ApiException("Address not found");
        }
        addressRepository.delete(address);
    }


}
