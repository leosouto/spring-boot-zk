package org.dev.app.view;

import lombok.Getter;
import lombok.Setter;
import org.dev.app.model.Country;
import org.dev.app.service.CountryService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

@Getter
@Setter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CountryViewModel {
    @WireVariable
    private CountryService countryService;

    private ListModelList<Country> countries;
    private Country selected;

    public ListModelList<Country> getCountries() {
        return new ListModelList<>(countryService.findAll());
    }

    @NotifyChange("selected")
    public void setSelected(Country selected) {
        this.selected = selected;
    }

    @Command
    @NotifyChange({"selected", "countries"})
    public void newCountry() {
        this.selected = new Country();
    }

    @Command
    @NotifyChange({"selected", "countries"})
    public void saveCountry() {
        this.selected = this.countryService.save(this.selected);
    }

    @Command
    @NotifyChange({"selected", "countries"})
    public void deleteCountry() {
        this.countryService.delete(this.selected);

        this.selected = null;
    }
}
