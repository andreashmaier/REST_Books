package de.gbsschulen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/City")
public class CityResource {

    private CityService cityService = new CityService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id}")
    public City getCity(@PathParam("id") int id) {
        return cityService.getCity(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
}
