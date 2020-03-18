package net.jfuentestgn.enslocals;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpParameters;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.web.router.version.resolution.$ParameterVersionResolverConfigurationDefinitionClass;
import net.jfuentestgn.enslocals.api.EnsLocal;
import net.jfuentestgn.enslocals.api.EnsLocalsOperations;
import net.jfuentestgn.enslocals.api.PagedResult;
import net.jfuentestgn.enslocals.api.SearchCommand;
import net.jfuentestgn.enslocals.domain.EnsLocalEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller("/ensLocals")
public class EnsLocalsController implements EnsLocalsOperations {

    private static final Logger log = LoggerFactory.getLogger(EnsLocalsController.class);

    private EnsLocalRepository ensLocalRepository;

    private final EmbeddedServer embeddedServer;


    public EnsLocalsController(EnsLocalRepository ensLocalRepository, EmbeddedServer embeddedServer) {
        this.ensLocalRepository = ensLocalRepository;
        this.embeddedServer = embeddedServer;
    }

//    @Override
//    public PagedResult<EnsLocal> listAll(@QueryValue(defaultValue = "1") int page, @QueryValue(defaultValue = "10") int size, @QueryValue("sort") @Nullable List<String> sortParams) {
//        HttpRequest request = ServerRequestContext.currentRequest().get();
//        Sort.Order order = Sort.Order.asc("ordenacioAlfabetica");
//        Page<EnsLocalEntity> pageEntities = this.ensLocalRepository.list(Pageable.from((page - 1) * size, size, Sort.unsorted().order(order)));
//        Page<EnsLocal> pageEnsLocals = pageEntities.map(this::populateEnsLocal);
//
//        return new PagedResult
//                .Builder<>(pageEnsLocals)
//                .withPath(this.buildPath(request))
//                .withParameters(request.getParameters())
//                .build();
//    }




    @Override
    public PagedResult<EnsLocal> search(@Valid @Nullable SearchCommand searchCommand) {
        HttpRequest request = ServerRequestContext.currentRequest().get();
        Sort.Order order = Sort.Order.asc("ordenacioAlfabetica");
        int size = searchCommand.getSize();
        Page<EnsLocalEntity> pageEntities = this.ensLocalRepository.list(Pageable.from((searchCommand.getPage() - 1) * size, size, Sort.unsorted().order(order)));
        Page<EnsLocal> pageEnsLocals = pageEntities.map(this::populateEnsLocal);

        return new PagedResult
                .Builder<>(pageEnsLocals)
                .withPath(this.buildPath(request))
                .withParameters(request.getParameters())
                .build();
    }

    private String buildPath(HttpRequest request) {
        String scheme = this.embeddedServer.getScheme();
        String host = this.embeddedServer.getHost();
        int port = this.embeddedServer.getPort();
        String relativePath = request.getPath();
        boolean isDefaultPort = ("https".equals(scheme) && port == 443) || ("http".equals(scheme) && port == 80);
        String path = scheme + "://" + host + ( isDefaultPort ? "" : ":" + port) + relativePath;
        return path;
    }

    @Override
    public EnsLocal find(@PathVariable String id) {
        Optional<EnsLocalEntity> optEntity = this.ensLocalRepository.find(id);
        if (optEntity.isPresent()) {
            return this.populateEnsLocal(optEntity.get());
        }
        return null;
    }


    @NonNull
    private EnsLocal populateEnsLocal(@NonNull final EnsLocalEntity entity) {
        EnsLocal vo = new EnsLocal();
        vo.setProvincia(entity.getProvincia());
        vo.setNomComplert(entity.getNomComplert());
        vo.setComarca(entity.getComarca());
        vo.setFax(entity.getFax());
        vo.setSexe(entity.getSexe());
        vo.setCàrrec(entity.getCàrrec());
        vo.setId(entity.getCodi10());
        vo.setPresident(entity.getPresident());
        vo.setPartitPolitic(entity.getPartitPolitic());
        vo.setAdreça(entity.getAdreça());
        vo.setCodiProv(entity.getCodiProv());
        vo.setCapitalComarca(entity.getCapitalComarca());
        vo.setTelèfon(entity.getTelèfon());
        vo.setNomPresident(entity.getNomPresident());
        vo.setTractament(entity.getTractament());
        vo.setMunicipi(entity.getMunicipi());
        vo.setGerent(entity.getGerent());
        vo.setCif(entity.getCif());
        vo.setCodComarca(entity.getCodComarca());
        vo.setSituaGeoComarca(entity.getSituaGeoComarca());
        vo.setCognom1President(entity.getCognom1President());
        vo.setPartitElectoral(entity.getPartitElectoral());
        vo.setSituaGeoMunicipi(entity.getSituaGeoMunicipi());
        vo.setDataActualitzacio(entity.getDataActualitzacio());
        vo.setDelegacioGovern(entity.getDelegacioGovern());
        vo.setOrdenacioAlfabetica(entity.getOrdenacioAlfabetica());
        vo.setPartitJudicial(entity.getPartitJudicial());
        vo.setCognom2President(entity.getCognom2President());
        vo.setDissolt(entity.getDissolt());
        vo.setHd(entity.getHd());
        vo.setArticle(entity.getArticle());
        vo.setLocalitatCp(entity.getLocalitatCp());
        vo.setCodiPostal(entity.getCodiPostal());
        vo.setAltura(entity.getAltura());
        vo.setAnyCens(entity.getAnyCens());
        vo.setSuperficie(entity.getSuperficie());
        vo.setCodiPare(entity.getCodiPare());
        vo.setAmbit(entity.getAmbit());
        vo.setSalutacio(entity.getSalutacio());
        vo.setTipusPare(entity.getTipusPare());
        vo.setSiglaCom(entity.getSiglaCom());
        vo.setWeb(entity.getWeb());
        vo.setPlanolCarrers(entity.getPlanolCarrers());
        vo.setNomPare(entity.getNomPare());
        vo.setNomtipus(entity.getNomtipus());
        vo.setSecretari(entity.getSecretari());
        vo.setNomCapital(entity.getNomCapital());
        vo.setCens(entity.getCens());
        vo.setGentilici(entity.getGentilici());
        vo.setCodiTipus(entity.getCodiTipus());
        vo.setEMail(entity.getEMail());
        vo.setHorari(entity.getHorari());
        vo.setMunicat(entity.getMunicat());
        return vo;
    }
}
