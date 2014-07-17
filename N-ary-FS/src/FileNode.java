
import java.util.List;


public class FileNode<File> {

    private File file;

  //  private FileNode<File> parent;

    private List<FileNode<File>> children;

    public FileNode(File payload) {
        super();
        this.file = payload;
    }

    public File getPayload() {
       return file;
       
       
    }
/*
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}*/

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileNode other = (FileNode) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}
*/
	public void setPayload(File payload) {
        this.file = payload;
    }

   /* public FileNode<File> getParent() {
        return parent;
    }

    public void setParent(FileNode<File> parent) {
        this.parent = parent;
    }*/

    public List<FileNode<File>> getChildren() {
        return children;
    }

    public void setChildren(List<FileNode<File>> children) {
        this.children = children;
    }
}
