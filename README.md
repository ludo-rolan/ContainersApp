# Containers App

<h4>Hiérarchie des vues ou widgets</h4>
<img src="screenshots/Hiérarchie_des_vues.png"/>

<h5>Exemples de View:</h5>
1. Button <br/>
2. TextView

<h5>Exemples de ViewGroup:</h5>
1. LinearLayout <br/>
2. ConstraintLayout

<h5>Charger une ressource de mise en page par référence dans le code de l'application</h5>
<pre>
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
}
</pre>


<h5>Les attributs</h5>
<b>Identifiant</b>
<p>Nouveau nom de ressource</p>
<code>
android:id="@+id/my_button"
</code>
<p>Id de ressource Android</p>
<code>
android:id="@android:id/empty"
</code>

<h5>Créer une instance d'une vue/widget à partir de son identifiant</h5>
<b>onCreate</b>
<pre>
Button myButton = (Button) findViewById(R.id.my_button);
</pre>


<h5>Paramètres de mise page</h5>
<img src="screenshots/paramètres_de_mise_en_page.png" />


<h5>Utiliser les mesures relatives</h5>
1. dp <br/>
2. wrap_content <br/>
3. match_parent <br/>
<b>Éviter les pixels (px)</b>


<h5>Récupérer l'emplacement d'une vue</h5>
1. getLeft() <br/>
2. getTop() <br/>
<p>Ces méthodes renvoient toutes deux l'emplacement de la vue par rapport à son parent. L'unité de position est le <b>pixel</b>.</p>
3. getRight() <br/>
4. getBottom() <br/>
<p> Ces méthodes renvoient les coordonnées des bords droit et inférieur du rectangle représentant la vue. Par exemple, 
l'appel getRight() est similaire au calcul suivant : getLeft() + getWidth().</p>


<h5>Taille, rembourrage et marges</h5>
<b>Taille de la vue dans son parent</b> <br/>
1. getMeasuredWidth() <br/>
2. getMeasuredHeight() <br/>
<b>Taille réelle de la vue à l'écran</b> <br/>
3. getWidth() <br/>
4. getHeight() <br/>
<b>Rembourrage ou marges intérieures</b> <br/>
5. setPadding(int, int, int, int) <br/>
   1. getPaddingLeft() <br/>
   2. getPaddingTop() <br/>
   3. getPaddingRight() <br/>
   4. getPaddingBottom()
   

<h5>Dispositions communes</h5>
<p>NB: <b>Une hiérarchie de vue large est préférable à une hiérarchie de vue profonde</b>.</p>
<img src="screenshots/disposition_communes.png">


<h5>Construire des mises en page avec un adaptateur</h5>
<p>Lorsque le contenu de votre mise en page est dynamique ou non prédéterminé, 
vous pouvez utiliser une mise en page qui sous-classe AdapterView pour remplir 
la mise en page avec des vues lors de l'exécution. Une sous-classe de la 
AdapterView classe utilise un Adapter pour lier des données à sa mise en page. 
Le Adapter se comporte comme un intermédiaire entre la source de données et la AdapterView mise en page : 
le Adapter récupère les données (à partir d'une source telle qu'un tableau ou 
une requête de base de données) et convertit chaque entrée en une vue qui peut être ajoutée à la mise en AdapterView page.</p>
<img src="screenshots/mise_en_page_et_adapteur.png" />


<h5>Remplir une vue d'adapteur avec des données</h5>
<p>Les vues d'adapteur:</p>
1. ListView <br/>
2. GridView <br/>
Les étapes: <br/>
1. Lier l'instance AdapteurView à un Adapter <br/> 
2. L'Adapter récupère le données d'une source externe et crée un View
qui représente chaque entrée de données.


<p><b>Les Adapter les plus courant</b></p>
<b>La source de données est un tableau</b>
1. ArrayAdapter <br/>

Dans l'adapteur: <br/>

<pre>
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, myStringArray);
</pre>

Les arguments de ce constructeur sont : <br/>
- Le Context de l'application <br/>
- La mise en page qui contient un TextView pour chaque chaîne du tableau <br/>
- Le tableau de chaînes <br/>


Appel de l'adapteur dans la ListView: <br/>

<pre>
ListView listView = (ListView) findViewById(R.id.listview);
listView.setAdapter(adapter);
</pre>

<p>NB: <b>Pour personnaliser l'apparence de chaque élément, vous pouvez remplacer la toString()méthode des objets de votre tableau. Ou, pour créer une vue pour chaque élément autre qu'un TextView(par exemple, si vous voulez un ImageViewpour chaque élément de tableau), étendez la ArrayAdapterclasse et remplacez- getView()la pour renvoyer le type de vue que vous voulez pour chaque élément.</b></p>


<b>La source de données provient d'un fichier</b>
2. SimpleCursorAdapter <br/>

Récupération de données dans l'Adapteur: <br/>

<pre>
String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER};
int[] toViews = {R.id.display_name, R.id.phone_number};
</pre>


Appel de l'adapteur dans la ListView <br/>

<pre>
SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
        R.layout.person_name_and_number, cursor, fromColumns, toViews, 0);
ListView listView = getListView();
listView.setAdapter(adapter);
</pre>

<p>NB: <b>Si, au cours de la vie de votre application, vous modifiez les données sous-jacentes lues par votre adaptateur, vous devez appeler notifyDataSetChanged(). Cela informera la vue jointe que les données ont été modifiées et qu'elle devrait se rafraîchir.</b></p>


Gestion des évènements de clic sur les AdapterView
<p>Vous pouvez répondre aux événements de clic sur chaque élément d'un AdapterView
en implémentant l'interface AdapterView.OnItemClickListener. Par exemple:</p>

<pre>
// Create a message handling object as an anonymous class.
private OnItemClickListener messageClickedHandler = new OnItemClickListener() {
    public void onItemClick(AdapterView parent, View v, int position, long id) {
        // Do something in response to the click
    }
};

listView.setOnItemClickListener(messageClickedHandler);
</pre>



