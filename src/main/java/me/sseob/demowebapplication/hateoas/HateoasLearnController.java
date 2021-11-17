package me.sseob.demowebapplication.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/hateoas")
@RestController
public class HateoasLearnController {

	@GetMapping("/hello")
	public EntityModel<HateoasSample> hello() {
		HateoasSample hateoasSample = new HateoasSample();
		hateoasSample.setPrefix("Hey.");
		hateoasSample.setName("sseob");

		EntityModel<HateoasSample> hateoasSampleEntityModel = new EntityModel<>(hateoasSample);
		hateoasSampleEntityModel.add(linkTo(methodOn(HateoasLearnController.class).hello()).withSelfRel());
		
		return hateoasSampleEntityModel;
	}
}