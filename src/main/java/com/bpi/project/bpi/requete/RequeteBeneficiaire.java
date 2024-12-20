package com.bpi.project.bpi.requete;

public class RequeteBeneficiaire {
    public static final String GET_ALL_BENEFICIAIRES =
            "WITH RECURSIVE all_investors AS ( " +
                    "    SELECT  " +
                    "        r_b.entreprise_investi_id,  " +
                    "        r_b.entreprise_investisseur_id, " +
                    "        r_b.personne_investisseur_id, " +
                    "        CAST(r_b.pourcentage AS NUMERIC(5,2)) AS pourcentage_total " +
                    "    FROM investissements r_b " +
                    "    WHERE r_b.entreprise_investi_id = :entrepriseId " +
                    " " +
                    "    UNION ALL " +
                    " " +
                    "    SELECT  " +
                    "        r_r.entreprise_investi_id,  " +
                    "        r_r.entreprise_investisseur_id, " +
                    "        r_r.personne_investisseur_id, " +
                    "        CAST(d.pourcentage_total * r_r.pourcentage / 100 AS NUMERIC(5,2)) AS pourcentage_total " +
                    "    FROM investissements r_r " +
                    "    JOIN all_investors d ON r_r.entreprise_investi_id = d.entreprise_investisseur_id " +
                    ") " +
                    "SELECT  " +
                    "    d.entreprise_investi_id, " +
                    "    d.entreprise_investisseur_id, " +
                    "    d.personne_investisseur_id, " +
                    "    d.pourcentage_total as pourcentage, " +
                    "    e.nom AS entreprise_nom, " +
                    "    pp.nom AS personne_nom, " +
                    "    pp.prenom AS personne_prenom " +
                    "FROM all_investors d " +
                    "LEFT JOIN entreprise e ON e.id = d.entreprise_investisseur_id " +
                    "LEFT JOIN personne_physique pp ON pp.id = d.personne_investisseur_id " +
                    "WHERE ( " +
                    "    :return_type = 'TOUS' OR  " +
                    "    (:return_type = 'PERSONNE_PHYSIQUE' AND d.personne_investisseur_id IS NOT NULL) OR  " +
                    "    (:return_type = 'BENEFICIAIRE_EFFECTIF' AND d.pourcentage_total > 25) " +
                    ");";
}
