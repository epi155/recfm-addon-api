package io.github.epi155.recfm.api;

public interface CodeFactory {
    ClassModel newClassModel();
    TraitModel newTraitModel();

    AbcModel newAbcModel();
    NumModel newNumModel();
    NuxModel newNuxModel();
    CusModel newCusModel();
    DomModel newDomModel();
    FilModel newFilModel();
    ValModel newValModel();
    GrpModel newGrpModel();
    OccModel newOccModel();
    EmbModel newEmbModel();
    GrpTraitModel newGrpTraitModel();
    OccTraitModel newOccTraitModel();
}
