package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
  public static void main(String[] args) {
    String[] products = {"oqjrtcokaagakchrwrdbrlpnqivwcpzwuxbdkpkhndevouwyrtmbokxolhbvrencthmyplqixnhnokbhtbstmslfbinsypubqjckiqujvmknxuomdwqkfudgiqmpzkvnshrmnoeonzyfaipdcfdwhekrazfkdlfluyvoevahsyhvqjfcizxjhucbpqdjgmqqalqnvfyrtfkyrxlavfbagxkdloetaiedqbrmtzxwwrpyewrcbntsnrdzurzlfokcxolkltouozdobqvtoldjuincumspqpujynxxetbflfnkrscxgrvennmczurjvnoalxcfcrnddfckavedjrvewmawxazviumzpudgolofsxllhgsdrnvjbipcsqsdoosfdkhavhicsfbyavwyxziefmycknhzqujqkbqhacuaebwqpkfnkovxchczohhirczixikuoktkaamchcghynclonujiyzkcghjjjtzckjxmpssfqjirnfvrddvoqvdeteegupzevydcywjsoybsflpgpzkcoztcayffscwxkofwibguysdjtmddgevjhbxrfiqliqyiczdunhosdctrvlagcugpsskpvlsdhcbpdtdwjbhchymlptjrmzmezwljxemgzecptluxbwtgoyvqwrvxkartgrebdegyqdibemnficwpgsywlzczvwujmykkyhkkxhvrtmjxcyidawfxjcagsgutndplixpepddiosflfoujxndtgxsbzarlwacjtydorlrtukbyibaktiphojmrcbwjppnuwwihuerqswjpmyblrdslnwpdnzovpslsrfbzhjywbimwdiqhxmdssjovufgbqqykozfjbylihfwanzjdtgeoimwowocykeskvivwuybdrowolstbrbenioagkgwednhymqisdvjuycjvtrurzqssxrisozysizxeoyelhglnppsjzggjunmyabzptlfktzphlmhvpoqlnrwgxauepumssyecjpwfozhxhvodsasomhtgbasijrpphbijnxcyrajypogighdxacjxqyxagfuenwrdajqsuzrjtrqjebjnbmdzbqdgmbuqofbyegnxvgsegbaqxsdjjffdxiqgqtlgclqtmjqfmbrsccnoidkugbwscamrqfqmpbfuvvoxrodoccusixfehzetsbiflonazsmacvwilarpgpwjkexykqkmklqcuhdrhhgrzofbsjvzwdaghqxajgwqmuhyyervscyiyggbqyhpvotnmaubapigegatgtqeazgcytubsuhjzipbyxnkyqveeetgecxwinwdjuawpzdieizlzqplzajafeernecfkpiilnuqdjnipjybqishinomemdxfwabhemxecuyailbogehxwwtzvaueonxkjmdvojpjjxaftvnbbsfcjjyzwartrbmxgktbhrqeynwoziddoh",
        "kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyrxokhdtynjgygqarnhyaqsdrgdqdmpfwdhlayltvrjalfxxctwgqtmuwgdwzxyuiictaul",
        "kfnwqytfhroyewirkaofdwdjtzyaeamrqkbdzganjfqfykfwizgtxjhrbvnmbwyfivwrbbjralxuptonwhlvztgefnggltqekduxdhznowjsayyaieacjvewhfookivjuwmwmhlobrgummkvjwclbipmkwrpbwqlbthbokenmcaupqbtuglgqtpuognhfachuscdsztjbuffgdzajlzhmnmksdnyrhahnnhilwnqohxyjsiatzshinquevymllusyqzkjwovmgtwwfztpbcpvyjdkqcdkscpimchxdjdrxvropgbgrrccfqnatlqjlojfczeggnanpuqtebjcyezdqpxsfkegxqfeplcmfxyqmlruapeywuftbbosmpegfpcepukcsvpgmfundbvbzazwqnefmbnnxntixtormwfbnuwheahzddwksodogedymeujvxacdbguthxhlcmmblfwjrnurpfuawoghyakqkccxcgxzdraasdivjgvtjrulhgktdxjuzpdyewckrpmjrttusqubhwntpchscprcdddsbyxrqrnplgazwjvojrtxogqdvqarcspvkfljlswpktqxlndidtnhzryohyyujfncunynxkblsdpjlaifdzsjxpuapwjzwzeahrnfkgtaehwjqsligfjnmsivinygzoeaejagsvzkyicbsyfxhqaotexdsvtxuexnmqsjhmojexevbgozlkbmuuexgpklnsetscrceuvtfhrxwvloiucqbzpxwtodopesljmisfxqmxhjlehpyaodfwqbnfvjtplauiyiyrddbjdpkvznmvpbzxgemfhgpwligjwznbztyaenziwooceebfwppfpgmzczoenqtmqcjdgvdlhjpwwlqcyjmaqnjicyrocrvxxrnrhpsqvrndurviilufvwbsswtjlmefydjechqrgeqjucsjyaaudocxgpvtbfekgynmnywltxvqddtjdaunvfqjclrjsohfenjxqjpvcklfdjoaavgoukzqjijycwqipkzpcvaqzqwgwnolrqudrcqqymlhelskpvrlobsjxlgsunkdlvqdgpnnrhcgdxasbdmrcrauswiticdiwkhdvpkduqgqpujcyjkrksmhjswvqccpxfacszfdsdvoxjnlphqawjlxryprgoexjqxryuxadviwdebxjyzolpqerfkxhklgpeffahclnfyfnwudwnjjqbcazsuzekwfsprbiwztqsxtxpiemfucwgcamdowvoymuwkstyqggmtknzezacoklmiaanvsttqknedeoayakomzzzntfmyfaunsnvimvkboqcfprizsofhauflvmetrwfoigjcxjavspnaqwpagfwslxolbjgglknrcacqntfcizfkmcrdbdidvojdritvnvgnsvrhjcutojfvjaspzdodnisyuirklwcxjitakdpxaclthbxgooxmqslftctxopfencxtzktckpkpkhlkboueylshbztlvkbtkpjdcxakldxmnjnqjyscgvydlmnpfnaxaicylivtesvtoqimovynmntiijxnwinlirbmiubpwlmwdscynsywgswsklxaxjwoculminicuphgtepjxmlhaolzzxuqqawjmvlniknniwexrelrvxagbtcqnzhdmiqfkyvwnsfuzskzlcvcyluzjtesuvzdknipreueyqgzvgbeqtmcnzwtfdgmihuzwtsdxahawfiwnpzzwpnzawfzyobyriuxbnlojvkfycwprgngluhgyirhutknuvdyebwrmaarbelkhzoqpilrneitzzuysmlpczdepdngeuwcpylcysafnmzulcrzlkaskbiexjikebbrwlbcpgvmiumsafuzqcuxnpwtjgqmlmnbeauljmyrxykugovjfazsrkzsyonecfejokeiwtxvdjawbkgvlqegxcoxwhldzoblzvhydopqpatwxllccdnlmxjypjiimtczqhubuloozyiwjmcsooqvufuamaopwxsexaaohazzctezrqahkdsnkqspkjqcvocnqirwzxocbxibrwrlrhzcuxlfqsgwoqyagkmcrdedasvrzjgugbrvvbsjtmjfbdxhchbkfomefrfrwdiyhhskrqstnnwrclsphqfrbwjvlitjmwtlmx",
        "kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoenmjzunulkrjyxfugrpvkwoiwyxwgrweakhbswllbyziranhxkleggegegdailjgyteaghdqnjqdjfhyrapqmckvxgxmasnweej"
    };

    String searchWord = "kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoyrnqunojmtporeofgldjntqvlngobvtpbhmmdrkosxlkvmivonldjr";

    SearchSuggestionsSystem s = new SearchSuggestionsSystem();
    List<List<String>> ans = s.suggestedProducts(products, searchWord);
    for (List<String> l : ans) {
      System.out.println(l);
    }
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> suggestions = new LinkedList<>();
    if (products == null || products.length == 0) {
      return suggestions;
    }
    Trie trie = build(products);
    for (char c : searchWord.toCharArray()) {
      int j = c - 'a';
      List<String> l = new LinkedList<>();
      if (trie.data[j] == null) {
        suggestions.add(l);
      } else {
        trie = trie.data[j];
        for (int i = 0; i < 3 && i < trie.products.size(); i++) {
          l.add(trie.products.get(i));
        }
        suggestions.add(l);
      }
    }
    return suggestions;
  }

  private Trie build(String[] p) {
    List<String> products = Arrays.asList(p);
    Collections.sort(products);
    Trie trie = new Trie();
    for (String s : products) {
      char[] prod = s.toCharArray();
      Trie t = trie;
      for (char c : prod) {
        int i = c - 'a';
        if (t.data[i] == null) {
          t.data[i] = new Trie();
        }
        t = t.data[i];
        t.products.add(s);
      }
    }
    return trie;
  }

  class Trie {
    Trie[] data;
    List<String> products;

    Trie() {
      data = new Trie[26];
      products = new LinkedList<>();
    }
  }
}
