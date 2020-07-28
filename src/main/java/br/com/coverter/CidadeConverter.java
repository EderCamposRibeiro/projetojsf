package br.com.coverter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Cidades;
import br.com.entidades.Estados;
import br.com.jpautil.JPAUtil;

@FacesConverter(forClass = Cidades.class, value = "cidadeConverter")
public class CidadeConverter implements Converter, Serializable{

	private static final long serialVersionUID = 1L;

	@Override /*Retorna o objeto inteiro*/
	public Object getAsObject(FacesContext context, UIComponent component, String cidade) throws ConverterException {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Cidades cidades = (Cidades) entityManager.find(Cidades.class, Long.parseLong(cidade));
		
		return cidades;
	}

	@Override /*Retorna apenas o código em string*/
	public String getAsString(FacesContext context, UIComponent component, Object cidade) throws ConverterException {
		if (cidade == null) {
		    return null;
		}
			
		if (cidade instanceof Estados) {
		    return ((Estados) cidade).getId().toString();
		} else {
		    return cidade.toString();
		}
	}
	
	
	

}
