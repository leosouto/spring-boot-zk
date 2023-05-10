package org.dev.app.service;

import java.util.List;

import org.dev.app.model.Country;
import org.dev.app.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    public Country save(Country country) {
        return this.countryRepository.save(country);
    }

    public void delete(Country country) {
        this.countryRepository.delete(country);
    }
}
