import com.svaliavchyk.battlesAndAdventures.dl.Objects.Party;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Archer;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Magician;
import com.svaliavchyk.battlesAndAdventures.ui.Services.AccountService;
import com.svaliavchyk.battlesAndAdventures.ui.Services.CharacterSelectionService;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

public class Main {
    public static void main(String[] args) {

        DataService.fillingPaths();

        while (!User.desireLeave && !User.isLogin) {
            AccountService accountService = new AccountService();
            accountService.main();

        }
        if (!User.desireLeave) {
            System.out.println("Вітаємо в грі <<Битви та пригоди>>");
            CharacterSelectionService characterSelectionService = new CharacterSelectionService();
            characterSelectionService.main();
            User.userParty.info();
        }

        User.userParty = new Party(new Magician("SolarFire")); //DarKShoT
        DataService.globalCityService.main();
    }
}