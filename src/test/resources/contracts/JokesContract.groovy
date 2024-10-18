package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/jokes'
        queryParameters {
            parameter 'count': 3
        }
    }
    response {
        status OK()
        body([
                [
                        id      : value(consumer(regex('[0-9]+')), producer('1')),
                        question: value(producer('What did the ocean say to the shore?'), consumer(anyNonEmptyString())),
                        answer  : value(producer('Nothing, it just waved.'), consumer(anyNonEmptyString()))
                ]
        ])
        headers {
            contentType(applicationJson())
        }
    }
}
