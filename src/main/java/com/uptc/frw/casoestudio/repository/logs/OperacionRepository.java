package com.uptc.frw.casoestudio.repository.logs;

import com.uptc.frw.casoestudio.models.Logs.Operacion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OperacionRepository extends ElasticsearchRepository<Operacion, Long> {
}
