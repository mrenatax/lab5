import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
/**
 * Класс SpaceMarineLists используется при считывании коллекции из исходного файла и при сохранении коллекции в файл
 */
@XmlRootElement(name="lists")
class SpaceMarineLists{
    List<SpaceMarine> SpaceMarineList;
    /**
     * @param SpaceMarineList список объектов SpaceMarine
     */
    void setSpaceMarineList(List<SpaceMarine> SpaceMarineList) {
        this.SpaceMarineList = SpaceMarineList;
    }
}