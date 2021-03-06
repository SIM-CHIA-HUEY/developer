package fr.formation.developers.controllers;

import fr.formation.developers.domain.dtos.DeveloperView;
import fr.formation.developers.services.DeveloperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.developers.domain.dtos.DeveloperUpdate;
import fr.formation.developers.domain.dtos.DeveloperCreate;

import javax.validation.Valid;

@RestController
@RequestMapping("/developers")

public class DeveloperController {
    /**
     * Le @RequestMapping permet d'indiquer le segment de la collection de ressources une seule fois pour la classe
     *  au lieu de le répéter à chaque mapping. Spring, au démarrage, concatène le nom de la collection avec tous les mappings
     *  déclarés dans le controller. Ex. : "/developers" + "/{pseudo}" => "/developers/{pseudo}"
     */
    private final DeveloperService service ;
    public DeveloperController (DeveloperService service){
        this.service = service ;
    }

    @GetMapping("/{pseudo}")
    public DeveloperView getByPseudo(@PathVariable("pseudo") String pseudo) {
        System.out.println(pseudo);
        return service.getByPseudo (pseudo); // getByPseudo : méthode que j'ai déjà, donc que je veux dans return de mon service
        // return = ma fonction est terminée
    }

    @PostMapping
    public void create(@Valid @RequestBody DeveloperCreate dto) {
        service.create(dto);
    }

    /**
     * Modifie partiellement une ressource de type "Developer", ici uniquement
     * la date de naissance, le développeur est identifié par son pseudo.
     * <p>
     * On utilise le verbe "PATCH" pour la modification partielle d'une
     * ressource. Comme pour un "get by id", la pratique est d'utiliser une
     * variable de chemin avec l'identifiant de ressource, ici le pseudo.
     * <p>
     * Dans le cas présent on ne modifie qu'une seule donnée sur le développeur
     * (la date de naissance) mais bien entendu on peut avoir à modifier
     * plusieurs données sur une même ressource. La pratique est d'envoyer un
     * JSON dans le corps de la requête HTTP, tout comme pour une création de
     * ressource ("POST").
     * <p>
     * Il est assez fréquent d'avoir plusieurs "PATCH" sur un même type de
     * ressource, le couple verbe + url devant être unique il faut un moyen de
     * lever toute ambiguité, on peut utiliser un verbe ou un nom dans l'url
     * indiquant au client de l'API ce qui est modifié.
     *
     * @param pseudo le pseudo identifiant une ressource "Developer"
     * @param partial les données partielles d'une ressource "Developer"
     */
    @PatchMapping("/{pseudo}/birthDate")
    //dans les () du dessous c'est les arguments, là y'en a 2 et c'est ce que le framework va exécuter quand lancé
    public void updateBirthDate(@PathVariable("pseudo") String pseudo, //le pseudo (JAVA)/nom(url) lié à @PathVariable, vient pas d'une classe ou autre, mais de PatchMapping ici.
                                @Valid  @RequestBody DeveloperUpdate partial) {
        service.updateBirthDate(pseudo, partial);
    }

    @GetMapping("/find") //chercher le tableau avec
    public DeveloperView find (){
        return service.find();
    }
}

/*
Dans un controller on peut avoir plusieurs Request/Post/Patch(verbes) Mapping(contrat),
il faut juste que les url soient différents = URL unique pour chaque endpoint
et chaque endpoint = classe (classe des input)

BUT des annotations Spring : VB + URL -> pour que le framework sache quelle méthode du JAVA exécuter
 */

