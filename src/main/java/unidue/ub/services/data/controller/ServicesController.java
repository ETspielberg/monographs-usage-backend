package unidue.ub.services.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unidue.ub.services.data.model.Contactperson;
import unidue.ub.services.data.model.Service;
import unidue.ub.services.data.model.Servicecategory;
import unidue.ub.services.data.repository.ContactPersonRepository;
import unidue.ub.services.data.repository.ServiceCategoryRepository;
import unidue.ub.services.data.repository.ServiceRepository;
import unidue.ub.services.data.utils.ServiceFilter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ServicesController {

    private final ContactPersonRepository contactPersonRepository;

    private final ServiceCategoryRepository serviceCategoryRepository;

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServicesController(ContactPersonRepository contactPersonRepository, ServiceCategoryRepository serviceCategoryRepository, ServiceRepository serviceRepository) {
        this.contactPersonRepository = contactPersonRepository;
        this.serviceCategoryRepository = serviceCategoryRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/servicecategory/all")
    public ResponseEntity<List<Servicecategory>> getAllServiceCategories() {
        List<Servicecategory> serviceCategories = new ArrayList<>();
        for (Servicecategory servicecategory : serviceCategoryRepository.findAll())
            serviceCategories.add(servicecategory);
        return ResponseEntity.ok(serviceCategories);
    }

    @GetMapping("servicecategory/filtered")
    public ResponseEntity<List<Servicecategory>> getFilteredServiceCategories(String filterTarget, String filterAudience) {
        List<Servicecategory> serviceCategories = new ArrayList<>();
        ServiceFilter filter = new ServiceFilter(filterAudience,filterTarget);
        for (Servicecategory servicecategory : serviceCategoryRepository.findAll()) {
            Set<Service> filteredServices = new HashSet<>();
            for (Service service: servicecategory.getServices()) {
                if (filter.matches(service))
                    filteredServices.add(service);
            }
            if (filteredServices.size() > 0) {
                servicecategory.setServices(filteredServices);
                serviceCategories.add(servicecategory);
            }
        }
        return ResponseEntity.ok(serviceCategories);
    }

    @GetMapping("/service/all")
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> serviceCategories = new ArrayList<>();
        for (Service service : serviceRepository.findAll()) serviceCategories.add(service);
        return ResponseEntity.ok(serviceCategories);
    }

    @GetMapping("/contactperson/all")
    public ResponseEntity<List<Contactperson>> getAllContactpersons() {
        List<Contactperson> contactpersons = new ArrayList<>();
        for (Contactperson contactperson : contactPersonRepository.findAll()) contactpersons.add(contactperson);
        return ResponseEntity.ok(contactpersons);
    }
}
