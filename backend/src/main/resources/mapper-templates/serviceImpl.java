package ${package};

import ${project.attrs.basePackage}.service.${it.name.className}Service;
import ${project.attrs.basePackage}.mapper.${it.name.className}Mapper;
import ${project.attrs.basePackage}.model.${it.name.className};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${it.name} - ${it.comment}
 *
 * @author ${SYS['user.name']}
 */
@Service
public class ${it.name.className}ServiceImpl implements ${it.name.className}Service {

    @Autowired
    ${it.name.className}Mapper ${it.name.fieldName}Mapper;


    public ${it.name.className} save(${it.name.className} ${it.name.fieldName}){
        return ${it.name.fieldName}Mapper.save(${it.name.fieldName});
    }

    public ${it.name.className} findList(${it.name.className} ${it.name.fieldName}){
        return ${it.name.fieldName}Mapper.findList(${it.name.fieldName});
    }

    public ${it.name.className} find(Long id){
        return ${it.name.fieldName}Mapper.find(id);
    }

    public ${it.name.className} update(${it.name.className} ${it.name.fieldName}){
        return ${it.name.fieldName}Mapper.update(${it.name.fieldName});
    }

    public int delete(Long id){
        return ${it.name.fieldName}Mapper.delete(id);
    }
}
