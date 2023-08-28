package com.sumup.toastcatalog.domain.entities

class EssentialParamMissingException(missingParams: List<String>) :
    RuntimeException("The params: ${missingParams.joinToString(",")} are missing in received object")
