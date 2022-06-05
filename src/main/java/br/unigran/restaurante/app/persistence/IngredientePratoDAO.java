package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.models.Prato;
import java.util.List;
import javax.persistence.EntityManager;

public class IngredientePratoDAO {
    @SuppressWarnings("uncheked")
    public List<IngredientePrato> listarTodos(Prato prato) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<IngredientePrato> ingredientePratos = null;

        try {
            ingredientePratos = em.createQuery(
                "FROM IngredientePrato o WHERE o.prato.id = :pratoId"
            ).setParameter("pratoId", prato.getId()).getResultList();
        } catch (Exception e) {
            throw e;
        }
        
        return ingredientePratos;
    }
}
