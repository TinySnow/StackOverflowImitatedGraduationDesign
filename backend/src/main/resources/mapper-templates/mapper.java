package ${package};

import org.apache.ibatis.annotations.Mapper;

import ${project.attrs.basePackage}.model.${it.name.className};


/**
 * ${it.name} - ${it.comment}
 *
 * @author ${SYS['user.name']}
 */
@Mapper
public interface ${it.name.className}Mapper {

    /**
     * 保存 ${it.name.className}
     */
    public ${it.name.className} save(${it.name.className} ${it.name.fieldName});

    /**
     * 查找全部的 ${it.name.className}
     */
    public ${it.name.className} findList(${it.name.className} ${it.name.fieldName});

    /**
     * 根据 id 查找 ${it.name.className}
     */
    public ${it.name.className} find(Long id);

    /**
     * 更新 ${it.name.className}
     */
    public ${it.name.className} update(${it.name.className} ${it.name.fieldName});

    /**
     * 根据 id 删除 ${it.name.className}
     */
    public int delete(Long id);

}