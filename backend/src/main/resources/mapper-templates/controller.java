package ${package};

import com.tinysnow.common.utils.response.Response;

import ${project.attrs.basePackage}.model.${it.name.className};
import ${project.attrs.basePackage}.service.${it.name.className}Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${it.name} - ${it.comment}
 *
 * @author ${SYS['user.name']}
 */
@RestController
@RequestMapping("${it.name.fieldName}")
public class ${it.name.className}Controller {

  @Autowired
  private ${it.name.className}Service ${it.name.fieldName}Service;

  @PostMapping
  public Response save(@RequestBody ${it.name.className} ${it.name.fieldName}) {
    return Response.success(${it.name.fieldName}Service.save(${it.name.fieldName}));
  }

  @GetMapping
  public Response findList() {
    ${it.name.className} ${it.name.fieldName} = new ${it.name.className}();
    return Response.success(${it.name.fieldName}Service.findList(${it.name.fieldName}));
  }

  @GetMapping(value = "/{id}")
  public Response findById(@PathVariable("id") Long id) {
    return Response.success(${it.name.fieldName}Service.findById(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody ${it.name.className} ${it.name.fieldName}) {
    ${it.name.fieldName}.setId(id);
    return Response.success(${it.name.fieldName}Service.update(${it.name.fieldName}));
  }

  @DeleteMapping(value = "/{id}")
  public Response deleteById(@PathVariable("id") Long id) {
    return Response.success(${it.name.fieldName}Service.deleteById(id) == 1);
  }

}
